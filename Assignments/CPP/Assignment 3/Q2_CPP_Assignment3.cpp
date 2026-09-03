#include <iostream>
#include <string>
#include <memory>

using namespace std;

//Part A: unique_ptr 
class Texture {
private:
    string name;
    int width;
    int height;

public:
    Texture(string n, int w, int h) : name(n), width(w), height(h) {
        cout << "[Texture Loaded]" << endl;
    }

    ~Texture() {
        cout << "[Texture Released]" << endl;
    }

    void display() const {
        cout << "Texture: " << name << " (" << width << "x" << height << ")" << endl;
    }
};

// Part B: shared_ptr
class Shader {
private:
    string name;
    string type;

public:
    Shader(string n, string t) : name(n), type(t) {
        cout << "[Shader Compiled]" << endl;
    }

    ~Shader() {
        cout << "[Shader Destroyed]" << endl;
    }

    int getReferenceCount(const shared_ptr<Shader>& ptr) {
        return ptr.use_count();
    }
};

//Part C: weak_ptr
class AudioClip {
private:
    string name;
    double duration;

public:
    AudioClip(string n, double d) : name(n), duration(d) {}

    string getName() const {
        return name;
    }
};

int main() {
    auto tex1 = make_unique<Texture>("player_sprite", 512, 512);
    tex1->display();

    // unique_ptr<Texture> tex2 = tex1; // why it failes: unique_ptr copy constructor is deleted to prevent shared ownership.

    unique_ptr<Texture> tex2 = move(tex1);
    cout << "tex1 is null: " << (tex1 == nullptr ? "YES" : "NO") << endl;

    auto shader = make_shared<Shader>("main_vert", "vertex");
    cout << "Ref count: " << shader.use_count() << endl; // 1
    {
        auto rendererRef = shader;
        cout << "Ref count: " << shader.use_count() << endl; // 2
        {
            auto editorRef = shader;
            cout << "Ref count: " << shader.use_count() << endl; // 3
        }
        cout << "Ref count: " << shader.use_count() << endl; // 2
    }
    cout << "Ref count: " << shader.use_count() << endl; // 1

    auto audio = make_shared<AudioClip>("explosion", 3.5);
    weak_ptr<AudioClip> observer = audio;

    if (auto clip = observer.lock()) {
        cout << "Clip alive: " << clip->getName() << endl;
    }

    audio.reset(); // unload

    if (observer.expired()) {
        cout << "Clip already unloaded." << endl;
    }

    return 0;
}